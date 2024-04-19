FROM python:3.10-slim

ENV PYTHONFAULTHANDLER=1 \
  PYTHONUNBUFFERED=1 \
  PYTHONHASHSEED=random \
  PIP_NO_CACHE_DIR=off \
  PIP_DISABLE_PIP_VERSION_CHECK=on \
  PIP_DEFAULT_TIMEOUT=100 \
  POETRY_VERSION=1.5.1

RUN groupadd user && useradd --create-home --home-dir /home/user -g user user

WORKDIR /home/user/app/

RUN pip install django djangorestframework psycopg2-binary

COPY apiPython/ /home/user/app

WORKDIR /home/user/app/
