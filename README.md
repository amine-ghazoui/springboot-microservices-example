# Système de Gestion de Facturation - Microservices

## 📋 Description

Application de gestion de facturation basée sur une architecture microservices permettant de gérer les clients, produits et factures.

## 🏗️ Architecture

```
springboot-microservices-example/
├── customer-service/        # Gestion des clients (Port 8081)
├── inventory-service/       # Gestion des produits (Port 8082)
├── billing-service/         # Gestion des factures (Port 8083)
├── gateway-service/         # API Gateway (Port 8888)
├── discovery-service/       # Eureka Server (Port 8761)
└── config-service/          # Configuration centralisée
```

**Schéma :**
```
Eureka (8761) ──► Gateway (8888) ──┬──► Customer Service (8081)
                                   ├──► Inventory Service (8082)
                                   └──► Billing Service (8083) [OpenFeign]
```

## 🚀 Technologies

- **Spring Boot** - Framework principal
- **Spring Cloud Gateway** - API Gateway
- **Eureka** - Service Discovery
- **Spring Data JPA** - Persistance
- **H2 Database** - Base de données
- **OpenFeign** - Communication inter-services
- **Swagger** - Documentation API
- **GraphQL** - API alternative
- **Lombok** - Réduction code boilerplate

## 📦 Services

### Customer Service
Gestion CRUD des clients avec API REST, GraphQL et Swagger.

### Inventory Service
Gestion CRUD des produits avec API REST, GraphQL et Swagger.

### Billing Service
Création de factures associant clients et produits via OpenFeign.

### Gateway Service
Point d'entrée unique avec routage dynamique vers tous les services.

### Discovery Service
Enregistrement et découverte automatique des microservices.

## 🛠️ Installation

**Ordre de démarrage :**
```bash
# 1. Discovery Service
cd discovery-service && mvn spring-boot:run

# 2. Services métier (ordre indifférent)
cd customer-service && mvn spring-boot:run
cd inventory-service && mvn spring-boot:run
cd billing-service && mvn spring-boot:run

# 3. Gateway
cd gateway-service && mvn spring-boot:run
```

## 🌐 URLs

| Service | URL |
|---------|-----|
| Gateway | http://localhost:8888 |
| Eureka | http://localhost:8761 |
| Customer API | http://localhost:8081/swagger-ui.html |
| Inventory API | http://localhost:8082/swagger-ui.html |
| Billing API | http://localhost:8083/swagger-ui.html |

## 🧪 Tests Postman

**Créer un client :**
```json
POST http://localhost:8888/api/customers
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

**Créer un produit :**
```json
POST http://localhost:8888/api/products
{
  "name": "Laptop",
  "price": 15000.00,
  "quantity": 10
}
```

**Créer une facture :**
```json
POST http://localhost:8888/api/bills
{
  "customerId": 1,
  "productItems": [
    {"productId": 1, "quantity": 2}
  ]
}
```

## 🎯 Fonctionnalités Implémentées

✅ CRUD Clients, Produits et Factures  
✅ API REST + GraphQL + Spring Data REST  
✅ Documentation Swagger  
✅ Architecture Microservices complète  
✅ Service Discovery (Eureka)  
✅ API Gateway avec routage dynamique  
✅ Communication OpenFeign  
✅ Configuration centralisée  
