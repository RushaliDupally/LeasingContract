# LeasingContract
This Project has the Code for a Leasing Contract. The user can lease a Contract. A Contract has the customer details and the vehicle Details. A Contract can have only one Customer and one Vehicle. But a Customer Can have any number of contracts.

# Technologies
1. Java
2. MySql
3. Maven
4. Spring Boot
5. HIbernate

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
