# Fetch current weather
A mini project using Spring Framework to fetch current weaher from open weather API.
# Requirements
* install JRE or JDK
# Usages
* create a local yaml config file named : ``src/main/resources/application-local.yaml``
* add in this file : 
```
provider:
  current: 'openweather'
openweather:
  key: YOUR API KEY FROM openweathermap.org
  baseUrl: 'http://api.openweathermap.org/data/2.5/weather'

```
* deploy and run `./mvnw spring-boot:run`
* go to : http://localhost:8080/
* API : 
  * method : GET
  * endpoint : localhost:8080/api/weather
  * body parameter as json : 
```json
{
    "cityName" : "Paris"
}
```
  * response : Current Location : Paris, Temp : 288.62, Humidity : 38, Wind speed : 10.29