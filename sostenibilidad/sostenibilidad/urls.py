"""
URL configuration for sostenibilidad project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.conf.urls.static import static
from django.contrib import admin
from django.urls import path
from django.conf import settings

import contenedores.views as contenedores

urlpatterns = [
    path("admin/", admin.site.urls),
    path("", contenedores.Escuelas),
    #path("contenedores/", contenedores.obtener_niveles, name="obtener_niveles"),
    path("contenedores/lista/<int:centro_id>/", contenedores.Visualizacion_datos, name="obtener_niveles_por_centro"),
    path("contenedores/visualizar/<int:contenedor_id>/", contenedores.Visualizacion_datos_contenedor, name="obtener_nivel_contenedor"),
]
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
