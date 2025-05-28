from django.shortcuts import HttpResponse
from django.template import loader
from django.http import JsonResponse

import requests
import datetime

from .models import Contenedor, Centro

import json


def Escuelas(request):
    """
    Vista para mostrar la página de selección de escuela.
    """

    doc = loader.get_template('servicio-gestion-residuos-UPM.html')

    centros = Centro.objects.all()

    ctx = {
        'centros': centros,
    }

    doc_template = doc.render(ctx)

    return HttpResponse(doc_template)

def Visualizacion_datos(request, escuelaid):

    doc = loader.get_template('visualizacion_datos.html')

    centro = Centro.objects.get(id=escuelaid)

    contenedores = Contenedor.objects.filter(Centro=centro)

    ctx = {
        'contenedores': contenedores,
        'centros': centro, 
    }

    doc_template = doc.render(ctx)

    return HttpResponse(doc_template)

def Visualizacion_datos_contenedor(request, contenedorid):

    doc = loader.get_template('visualizacion_datos_contenedor.html')

    contenedor = Contenedor.objects.get(id=contenedorid)

    ctx = {
        'contenedor': contenedor,
    }

    doc_template = doc.render(ctx)

    return HttpResponse(doc_template)
