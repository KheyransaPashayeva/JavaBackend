package az.atl.springcustomer.service.impl;

import az.atl.springcustomer.dao.entity.CustomerEntity;
import az.atl.springcustomer.dao.repository.CustomerRepository;
import az.atl.springcustomer.exception.CustomerNotFoundException;
import az.atl.springcustomer.mapper.CustomerMapper;
import az.atl.springcustomer.model.dto.CustomerDto;
import az.atl.springcustomer.model.request.CustomerRequest;
import az.atl.springcustomer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    //private final ModelMapper modelMapper;
    @Override
    public CustomerDto create(CustomerRequest customerRequest) {
        CustomerEntity customerEntity=customerMapper.toEntity(customerRequest);
        return customerMapper.toDto(customerRepository.save(customerEntity));
    }

    @Override
    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(()->new CustomerNotFoundException("student not found with id"+id));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public void update(Long id, CustomerDto customerDto) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("student id not found"));
               customerEntity.setId(customerDto.getId());
               customerEntity.setName(customerDto.getName());
               customerEntity.setLastname(customerDto.getLastname());
               customerEntity.setEmail(customerDto.getEmail());

                customerRepository.save(customerEntity);
    }

    @Override
    public void delete(Long id) {
        customerRepository.findById(id)
                .ifPresent(studentEntity ->  customerRepository.deleteById(id));
    }
}
