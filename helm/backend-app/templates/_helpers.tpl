{{/*
Expand the name of the chart.
*/}}
{{- define "backend-app.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "backend-app.fullname" -}}
{{- if .Values.fullnameOverride }}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- $name := default .Chart.Name .Values.nameOverride }}
{{- if contains $name .Release.Name }}
{{- .Release.Name | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" }}
{{- end }}
{{- end }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "backend-app.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "backend-app.labels" -}}
helm.sh/chart: {{ include "backend-app.chart" . }}
{{ include "backend-app.selectorLabels" . }}
{{- if .Values.serviceApp.image.tag }}
app.kubernetes.io/version: {{ .Values.serviceApp.image.tag }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "backend-app.selectorLabels" -}}
app.kubernetes.io/name: {{ include "backend-app.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/current_date: {{ now | htmlDate }}
app.kubernetes.io/version: {{ .Release.version }}
{{- end }}

{{/*
Create the name of the service account to use
*/}}
{{- define "backend-app.serviceAccountName" -}}
{{- if .Values.serviceAccount.create }}
{{- default (include "backend-app.fullname" .) .Values.serviceAccount.name }}
{{- else }}
{{- default "default" .Values.serviceAccount.name }}
{{- end }}
{{- end }}
