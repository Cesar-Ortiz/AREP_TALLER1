# Escuela Colombiana de Ingeniería Julio Garavito
## 👤 Autor
César Fernando Ortiz Rocha

## Despliegues
#### 🚀 Despliegue API Client (Java) [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://sparkwebprimero.herokuapp.com/getTime/ibm/daily)

#### 🚀 Despliegue WEB Client (JavasScript) [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://sparkwebprimero.herokuapp.com)

## 📈 Arquitectura

### Diagrama de clases
![](img/DiagamaDeClases.PNG)
### Diagrama de despliegue
![](img/DiagramaDespliegue.PNG)
## Meroria cache
Se creo una clase nueva para el cache llamada Cache en la cual se implemento un HashMap que va a guardar los datos que se consultan por primera vez, cuando se vuelva a consultar por el mismo dato no sera necesario hacer el llamado al API externo si no que se extraera el dato del HashMap.

![](img/Cache.PNG)
## Extensibilidad
Para ser extensible esta aplicación, se podría crear una clase que extienda de HttpStockService y dentro de esta nueva clase se pondria la implementación del nuevo API externo, la cual tendria la url que duevuelva la información.
