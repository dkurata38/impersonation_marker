FROM python:2.7

ENV PYTHONUNBUFFERED 1

# RUN apk --update-cache add gcc
RUN mkdir -p /tmp
WORKDIR /tmp
ADD requirements.txt /tmp
RUN pip install -r requirements.txt
RUN pip install scikits.talkbox

RUN mkdir /app
WORKDIR /app
