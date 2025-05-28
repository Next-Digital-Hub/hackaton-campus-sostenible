from django.db import models

# Create your models here.
class Contenedor(models.Model):
    """
    Base de datos para almacenar información de contenedores de residuos.
    """
    contenedorId = models.CharField(max_length=100)
    tipo_contenedor = models.CharField(max_length=50)
    centro = models.ForeignKey('Centro', on_delete=models.CASCADE, related_name='contenedores')
    latitud = models.FloatField()
    longitud = models.FloatField()
    capacidad = models.IntegerField()
    unidades = models.CharField(max_length=100)

    fecha_instalacion = models.DateField()

    historico_capacidades = models.JSONField(default=list, blank=True)

class Centro(models.Model):
    """
    Base de datos para almacenar información de centros de reciclaje.
    """
    centro = models.CharField(max_length=1000, unique=True)
