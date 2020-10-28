## BackEnd  

#### Hotel Back End

Serviço que consulta o Broken dos Hotéis e Calcula o valor da diária.

## Starting application local


**Building**

Para executar o projeto, execute os seguintes passos (dentro da raiz do projeto):

1 - mvn spring-boot:run

**Parâmetros obrigatórios** 
1. cityId
2. checkInDate
3. checkOutDate
4. numberOfAdults
5. numberOfChildren

**Testing**

Para consulta  por ID da Cidade:

1. cityId - Código da Cidade
2. checkInDate - Data de Checkin
3. checkOutDate - Data de Checkout
4. numberOfAdults - Número de Adultos
5. numberOfChildren - Número de Crianças

http://localhost:8080/citys/{cityID}/hotels/checkIn/{checkInDate}/checkOut/{checkOutDate}/adults/{numberOfAdults}/children/{numberOfChildren}

Exemplo: http://localhost:8080/citys/9626/hotels/checkIn/26-10-2020/checkOut/26-10-2020/adults/1/children/1

----------------------------------------------------------------------
Para consulta  por ID do Hotel:

1. cityId - Código da Cidade
2. checkInDate - Data de Checkin
3. checkOutDate - Data de Checkout
4. numberOfAdults - Número de Adultos
5. numberOfChildren - Número de Crianças
6. hotelID - ID do Hotel 

http://localhost:8080/citys/{cityID}/hotels/{hotelID}/checkIn/{checkInDate}/checkOut/{checkOutDate}/adults/{numberOfAdults}/children/{numberOfChildren}

Exemplo: http://localhost:8080/citys/9626/hotels/0/checkIn/26-10-2020/checkOut/26-10-2020/adults/1/children/1

 