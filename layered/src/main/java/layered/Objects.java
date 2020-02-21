1/**presentation layer**/
	@Controller
	@RequiredArgsConstructor
	public class CustomerController {
	  
	  private final CustomerService customerService;

	  @PostMapping(value = "/customers/add-money")
	  public @ResponseBody CustomerAddMoneyDTO addMoney(@RequestBody CustomerAddMoneyDTO dto) {
	    return customerService.addFundsToCustomer(dto);
	  }
}
2
/**Application Layer**/
/**the mapper class to transform Entity model to DTO.**/
	@Repository
	public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	    
	    CustomerEntity findByUsername(String username);
	    
	}
3/**we can add our Data Layer that will be our connection to the database**/
/**Data Layer**/

	@Component
	class CustomerMapper {
	  
	  public CustomerAddMoneyDto mapToDto(CustomerEntity customerEntity) {
	    CustomerAddMoneyDto dto = new CustomerAddMoneyDto();
	    dto.username = customerEntity.getUsername();
	    dto.moneyAmount = customerEntity.getMoneyAmount();
	    return dto;
	  }
	  
	}

	@Service
	@AllArgsConstructor
	class CustomerService {
	  
	  private final CustomerRepository customerRepository;
	  private final CustomerMapper customerMapper;
	  
	  public CustomerAddMoneyDto addFundsToCustomer(
	    CustomerAddMoneyDto dto) {
	  
	    CustomerEntity customerEntity = customerRepository.findByUsername(dto.getUsername());
	    customerEntity.moneyAmount += dto.getMoneyAmount();
	    return customerMapper.mapToDto(customerRepository.save(customerEntity));
	  }
	  
	}
}
4/**: Data Transfer Objects, Domain Objects, Entity Objects.**/
public class Objects {
	class CustomerAddMoneyDTO {
		  
		  public String username;
		  public Integer moneyAmount;
		  
		}

		class Customer {
		  
		  public String username;
		  public String password;
		  public String moneyAmount;
		  
		}

		@Entity
		@Table(name="CUSTOMER")
		class CustomerEntity {
		  
		  @Id
		  @GeneratedValue(strategy=GenerationType.AUTO)
		  public Long id;
		   
		  @Column(name="USERNAME")
		  public String username;
		  
		  @Column(name="PASSWORD")
		  public String password;
		  
		  @Column(name="MONEY_AMOUNT")
		  public Integer moneyAmount;
		  
		}

}
	  