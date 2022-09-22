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

# Rest APIs

# Vehicle
<ul>
  <li>Method: POST</li>
  <li>API End Point: "http://localhost:8080/vehicle/save"</li>
  <li>{
	"brand":"BMW",
	"model":"abc",
	"year":2022,
	"price":128889
	}</li>
  </ul>
