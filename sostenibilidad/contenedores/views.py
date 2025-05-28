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

    doc = loader.get_template('listado-contenedores.html')

    centro = Centro.objects.get(id=escuelaid)

    contenedores = Contenedor.objects.filter(Centro=centro)

    ctx = {
        'contenedores': contenedores,
        'centros': centro, 
    }

    doc_template = doc.render(ctx)

    return HttpResponse(doc_template)

def Visualizacion_datos_contenedor(request, contenedorid):

    doc = loader.get_template('grafico-contenedor.html')

    contenedor = Contenedor.objects.get(id=contenedorid)

    if contenedor.historico_capacidades:
        ultimo_nivel = contenedor.historico_capacidades[-1]['nivel']
        critico = ultimo_nivel > (contenedor.capacidad * 0.75)
    else:
        critico = False

    ctx = {
        'contenedor': contenedor,
        'critico': critico,
    }

    doc_template = doc.render(ctx)

    return HttpResponse(doc_template)
