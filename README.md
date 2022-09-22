# LeasingContract
This Project has the Code for a Leasing Contract. The user can lease a Contract. A Contract has the customer details and the vehicle Details. A Contract can have only one Customer and one Vehicle. But a Customer Can have any number of contracts.

# Technologies
1. Java
2. MySql
3. Maven
4. Spring Boot
5. HIbernate

# Execution Comments
Clone the Repository in your Local. Update Maven. Go to DemoApplication.java class of com.allane.contract package. Right Click and Run as Spring Boot Application.

# Database
<ul>
  <li>allanedb</li>
</ul> 

# Tables
<ul>
  <li>Customer</li>
<ul>
  <li>first_name</li>
  <li>last_name</li>
  <li>dob</li>
</ul> 
</ul> 
<ul>
  <li>Vehicle</li>
<ul>
  <li>vin</li>
  <li>brand</li>
  <li>model</li>  
  <li>year</li>
  <li>price</li>
</ul> 
</ul>
<ul>
  <li>Contract</li>
<ul>
  <li>contract_number</li>
  <li>monthly_rate</li>
  <li>vehicle_vin</li>  
  <li>customer_oid</li>
</ul> 
</ul>

# Hibernate Mappings
<ul>
	<li> One-to-One Mapping between Contract and Vehicle Table</li>
	<li> Many-to-One Mapping between Contract and Customer Table</li>
</ul>

# Validations Implemented
<ul>
<li> Cannot be empty, cannot contain numbers, special charecters and length shouldnot br greater than 64 Characters. Implemented On:
	<ul>
		<li>Customer: first Name</li>
		<li>Customer: Last Name</li>
		<li>Vehicle: Brand Name</li>
		<li>Vehicle: Model Name</li>
	</ul>
</li>
</ul>

<ul>
<li> Vehicle price, Vehicle year and Contract Montly Rate cannot be Negative.</li>
<li> Vehicle Year length should not be more than 4.</li>
<li> Valid Date of Birth.</li>
<li> User cannot delete the Vehicle if it is assigned to a Contract and Vice Versa.</li>
<li> User cannot delete the Customer if it is assigned to a Contract and Vice Versa.</li>
</ul>

# Packages

<h2>src/main/java</h2>
<ul>
	<li>com.allane.contract</li>
	<ul>
	<li>DemoApplication.java: Has the Main Method to Execute the Application.</li>
</ul>
</ul>
<ul>
	<li>com.allane.contract.controller</li>
	<ul>
	<li>ContractController.java: Controller class for Contract.</li>
		<li>CustomerController.java: Controller class for Customer.</li>
		<li>VehicleController.java: Controller class for Vehicle.</li>
</ul>
</ul>
<ul>
	<li>com.allane.contract.entity</li>
	<ul>
	<li>Contract.java: Entity class for Contract.</li>
		<li>Customer.java: Entity class for Customer.</li>
		<li>Vehicle.java: Entity class for Vehicle.</li>
</ul>
</ul>
<ul>
	<li>com.allane.contract.repository</li>
	<ul>
	<li>ContractRepository.java: Repository class for Contract.</li>
		<li>CustomerRepository.java: Repository class for Customer.</li>
		<li>VehicleRepository.java: Repository class for Vehicle.</li>
</ul>
</ul>

<ul>
	<li>com.allane.contract.service</li>
	<ul>
	<li>ContractService.java: Service Interface for Contract.</li>
		<li>CustomerService.java: Service Interface for Customer.</li>
		<li>VehicleService.java: Service Interface for Vehicle.</li>
</ul>
</ul>

<ul>
	<li>com.allane.contract.service.impl</li>
	<ul>
	<li>ContractRepository.java: Service Implementation class for Contract.</li>
		<li>CustomerRepository.java: Service Implementation class for Customer.</li>
		<li>VehicleRepository.java: Service Implementation class for Vehicle.</li>
</ul>
</ul>

<ul>
	<li>com.allane.contract.validations</li>
	<ul>
	<li>Constants.java: File having all the constants.</li>
		<li>GenericValidations.java: Generic Validations like not empty, having spl charecters, having numbers, length greater than 64, price/year non Negative.</li>
		<li>ContractValidations.java: Validations of Vehicle.</li>
		<li>CustomerValidations.java: Validations of Customer.</li>
		<li>VehicleValidations.java:  Validations of Vehicle.</li>
</ul>
</ul>

<ul>
	<li>com.allane.contract.exceptions</li>
	<ul>
	<li>GlobalExceptionHandler.java: Handling Exceptions Globally.</li>
	<li>BusinessException.java: Business Exceptions.</li>
	<li>EmptyFieldException.java: Empty Field Exceptions.</li>
	</ul>
</ul>


<ul>
	<li>com.allane.contract.dto</li>
	<ul>
	<li>ContractDetailsFormDTO.java: Contract Details Form DTO.</li>
	<li>ContractOverviewDTO.java: Contract Overview of DTO.</li>
	<li>DropdownDTO.java: Dropdown DTO.</li>
	<li>ErrorDetails.java: Error Details DTO.</li>
	<li>ErrorResponse.java: Error Response of DTO.</li>
	<li>Response.java: Response of DTO.</li>
	</ul>
</ul>

<h2>src/test/java</h2>

<ul>
	<li>com.allane.contract</li>
	<ul>
	<li>CustomerControllerTest.java: Unit Test Cases of Customer Controller.</li>
	<li>DemoApplicationTests.java: Unit Test Cases of Contract Controller.</li>
	<li>VehicleControllerTest.java: Unit Test Cases of Vehicle Controller.</li>
	</ul>
</ul>

# APIs Implemented

<h2>Vehicle</h2>
<ul>
	<li>"http://localhost:8080/vehicle/save", Method: POST, Description:Save Vehicle data by providing payload.</li>
	<li>"http://localhost:8080/vehicle/get/{vin}", Method: GET, Description:Get Vehicle data by providing Id in the URL.</li>
	<li>"http://localhost:8080/vehicle/update/{id}", Method: PUT, Description:Update Vehicle data by providing payload and the vin in the URL.</li>
	<li>"http://localhost:8080/vehicle/delete/{id}", Method: DELETE, Description:Delete Vehicle data by providing Id in the URL.</li>	
	<li>"http://localhost:8080/vehicle/getAll", Method: GET, Description: Get the whole Vehicle Data.</li>
	<li>"http://localhost:8080/vehicle/delete", Method: DELETE, Description:Delete the wholeVehicle data.</li>
</ul>

<h2>Customer</h2>
<ul>
	<li>"http://localhost:8080/customer/save", Method: POST, Description:Save Customer data by providing payload.</li>
	<li>"http://localhost:8080/customer/get/{vin}", Method: GET, Description:Get Customer data by providing Id in the URL.</li>
	<li>"http://localhost:8080/customer/update/{id}", Method: PUT, Description:Update Customer data by providing payload and the id in the URL.</li>
	<li>"http://localhost:8080/customer/delete/{id}", Method: DELETE, Description:Delete Customer data by providing Id in the URL.</li>	
	<li>"http://localhost:8080/customer/getAll", Method: GET, Description: Get the whole Customer Data.</li>
	<li>"http://localhost:8080/customer/delete", Method: DELETE, Description:Delete the whole Customer data.</li>
</ul>

<h2>Contract</h2>
<ul>
	<li>"http://localhost:8080/contract/save", Method: POST, Description:Save Contract data by providing payload.</li>
	<li>"http://localhost:8080/contract/get/{vin}", Method: GET, Description:Get Contract data by providing Id in the URL.</li>
	<li>"http://localhost:8080/contract/update/{id}", Method: PUT, Description:Update Contract data by providing payload and the Contract Number in the URL.</li>
	<li>"http://localhost:8080/contract/delete/{id}", Method: DELETE, Description:Delete Contract data by providing Id in the URL.</li>	
	<li>"http://localhost:8080/contract/getDropdownDetails", Method: GET, Description: Gets the Customer and Vehicle Dropdown data.</li>
	<li>"http://localhost:8080/contract//unMapCustomer/{id}", Method: DELETE, Description: Un maps Customer from the contract.</li>
	<li>"http://localhost:8080/contract//unMapVehicle/{id}", Method: DELETE, Description: Un maps Vehicle from the contract.</li>
	<li>"http://localhost:8080/contract/getAll", Method: GET, Description: Get the whole Contract Data.</li>
	<li>"http://localhost:8080/contract/delete", Method: DELETE, Description:Delete the whole Contract data.</li>
</ul>

# LOG Files

log.txt file: Contains the APplication cost.

# Rest APIs

# Vehicle

<h3> Save Vehicle Data</h3>
<ul>
  <li>Method: POST</li>
  <li>API End Point: "http://localhost:8080/vehicle/save"</li>
  <li>Request payoad: {
	"brand":"BMW",
	"model":"abc",
	"year":2022,
	"price":128889
	}</li>
  </ul>
  
<h3> Get Vehicle Data</h3>
<ul>
  <li>Method: GET</li>
  <li>API End Point: "http://localhost:8080/vehicle/get/{vin}"</li>
  <li>Response Payload:{
	"vin":"2222",
	"brand":"BMW",
	"model":"abc",
	"year":2022,
	"price":128889
	}</li>
  </ul>
  
  <h3>Update Vehicle Data</h3>
<ul>
  <li>Method: PUT</li>
  <li>API End Point: "http://localhost:8080/vehicle/update"</li>
  <li>Request Payload:{
	"vin":"2222",
	"brand":"BMW",
	"model":"X5",
	"year":2022,
	"price":128889
	}</li>
  </ul>
  
  <h3> Delete Vehicle Data</h3>
<ul>
  <li>Method: DELETE</li>
  <li>API End Point: "http://localhost:8080/vehicle/delete/{vin}"</li>
  </ul>


# Customer

<h3> Save Customer Data</h3>
<ul>
  <li>Method: POST</li>
  <li>API End Point: "http://localhost:8080/customer/save"</li>
  <li>Request payoad: {
"firstName": "Charles",
    "lastName": "Elvis",
    "dob": "2022-01-01"
	}</li>
  </ul>
  
<h3> Get Customer Data</h3>
<ul>
  <li>Method: GET</li>
  <li>API End Point: "http://localhost:8080/customer/get/{vin}"</li>
  <li>Response Payload:{
	  "id":1,
"firstName": "Charles",
    "lastName": "Elvis",
    "dob": "2022-01-01"
	}</li>
  </ul>
  
  <h3>Update Customer Data</h3>
<ul>
  <li>Method: PUT</li>
  <li>API End Point: "http://localhost:8080/customer/update"</li>
  <li>Request Payload:{
	  "id":1,
"firstName": "Charles",
    "lastName": "Elvis",
    "dob": "2022-01-01"
	}}</li>
  </ul>
  
  <h3> Delete Vehicle Data</h3>
<ul>
  <li>Method: DELETE</li>
  <li>API End Point: "http://localhost:8080/customer/delete/{id}"</li>
  </ul>
  
# Contract

  <h3> Get All Contract Details</h3>
<ul>
  <li>Method: GET</li>
  <li>API End Point: "http://localhost:8080/contract/getAllContracts"</li>
<li> Gets all the Contract Details</li>
  </ul>

<h3> Save Contract Data</h3>
<ul>
  <li>Method: POST</li>
  <li>API End Point: "http://localhost:8080/contract/save"</li>
  <li>Request payoad: {
	"contractNumber":11111,
	"monthlyRate":12.2,
	"vehicle":{
	"vin":2,
	"brand":"BMW",
	"model":"abc",
	"year":2022,
	"price":128889
	},
	"customer":{
    "id": 1,
    "firstName": "Charles",
    "lastName": "Elvis",
    "dob": "2022-01-01"
}
}</li>
  </ul>
  
<h3> Get Contract Data</h3>
<ul>
  <li>Method: GET</li>
  <li>API End Point: "http://localhost:8080/contract/get/{vin}"</li>
  <li>Response Payload:{
	"contractNumber":11111,
	"monthlyRate":12.2,
	"vehicle":{
	"vin":2,
	"brand":"BMW",
	"model":"abc",
	"year":2022,
	"price":128889
	},
	"customer":{
    "id": 1,
    "firstName": "Charles",
    "lastName": "Elvis",
    "dob": "2022-01-01"
}
}</li>
  </ul>
  
  <h3>Update Contract Data</h3>
<ul>
  <li>Method: PUT</li>
  <li>API End Point: "http://localhost:8080/contract/update"</li>
  <li>Request Payload:{
	"contractNumber":11111,
	"monthlyRate":12.2,
	"vehicle":{
	"vin":2,
	"brand":"BMW",
	"model":"abc",
	"year":2022,
	"price":128889
	},
	"customer":{
    "id": 1,
    "firstName": "Charles",
    "lastName": "Elvis",
    "dob": "2022-01-01"
}
}</li>
  </ul>
  
  <h3> Delete Contract Data</h3>
<ul>
  <li>Method: DELETE</li>
  <li>API End Point: "http://localhost:8080/contract/delete/{id}"</li>
  </ul>
