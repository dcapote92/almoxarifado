package com.angerbytes.almoxarifado.services.exceptions

class ResourceNotFoundException(id: Any):
    RuntimeException("Resource not found. Id: $id")
