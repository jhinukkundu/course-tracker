FROM ubuntu:latest
LABEL authors="musib"

ENTRYPOINT ["top", "-b"]