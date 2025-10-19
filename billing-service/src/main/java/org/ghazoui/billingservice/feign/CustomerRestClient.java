package org.ghazoui.billingservice.feign;

import org.ghazoui.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();

}

/*
cette interface est un client Feign qui permet de communiquer avec le service customer-service,
en utilisant l'annotation @FeignClient avec le nom du service, puis elle définit une méthode
qui utilise l'annotation @GetMapping pour faire une requête GET vers l'URL spécifiée.
 */

/*
PagedModel : c'est un objet qui contient une liste de ressources paginées.
 contient Embedded resources, et une liste de Customer.

PagedModel est une structure de Spring HATEOAS qui représente une collection paginée de ressources
(ex. liste d’objets avec métadonnées de pagination et liens HATEOAS).
 */
