#!/bin/bash

curl -X GET localhost:8080/welcome

curl -X GET localhost:8080/welcome/233

echo ""
curl -X GET "http://localhost:8080/getWelcome?key=yameiro&getClient=nmsl"
echo ""

echo ""
curl -X GET "http://localhost:8080/stonks/panic/kalm/"
echo ""

echo ""
curl -X GET "localhost:8080/nonstonks/welcome/RequestParam?id=777"
echo ""

#curl -X GET -H"Accept: text" localhost:8080/getWelcome?key=yameiro&getClient=nmsl


