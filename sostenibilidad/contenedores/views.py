from django.shortcuts import HttpResponse
from django.template import loader
from django.http import JsonResponse

import requests
import datetime

from .models import Contenedor, Centro

import json

# Create your views here.
def obtener_niveles(request):
    url = "https://hackaton-campus-sostenible-api.mmartinez-d6a.workers.dev/containers/measurements"
    headers = {
        "Authorization": "Bearer campus-sostenible-2025"
    }

    try:
        response = requests.get(url, headers=headers)
        response.raise_for_status()
        data_api = response.json()

        resultado = []

        for item in data_api:
            if Contenedor.objects.get(contenedorId = item["id"]).exist():
                contenedor = Contenedor.objects.get(contenedorId=item["id"])
                contenedor.historico_capacidades.append({
                    "fecha": datetime.strptime(item["date"], "%Y-%m-%dT%H:%M:%S.%fZ"),
                    "nivel": item["level"]
                })
                contenedor.save()
            else:
                if not Centro.objects.filter(id=item["centro"]).exists():
                    centro = Centro(
                        centro=item["center_name"]
                    )
                    centro.save()
                else:
                    centro = Centro.objects.get(id=item["centro"])
                contenedor = Contenedor(
                    contenedorId=item["id"],
                    tipo_contenedor=item["type"],
                    centro=Centro.objects.get(id=item["centro"]),
                    latitud=item["latitude"],
                    longitud=item["longitude"],
                    capacidad=item["capacity"],
                    unidades=item["units"],
                    fecha_instalacion=datetime.datetime.strptime(item["installation_date"], "%Y-%m-%d"),
                    historico_capacidades=[{
                        "fecha": datetime.datetime.strptime(item["date"], "%Y-%m-%dT%H:%M:%S.%fZ"),
                        "nivel": item["level"]
                    }]
                )
                contenedor.save()

        return JsonResponse(resultado, safe=False)

    except requests.RequestException as e:
        return JsonResponse({"error": str(e)}, status=500)

def Escuelas(request):
    """
    Vista para mostrar la página de selección de escuela.
    """

    doc = loader.get_template('escuelas.html')

    centros = Centro.objects.all()

    ctx = {
        'centros': centros,
    }

    doc_template = doc.render(ctx)

    return HttpResponse(doc_template)

def Visualizacion_datos(request, escuelaid):

    doc = loader.get_template('visualizacion_datos.html')

    contenedores = Contenedor.objects.filter(Centro=Centro.objects.get(id=escuelaid))

    ctx = {
        'contenedores': contenedores,
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
