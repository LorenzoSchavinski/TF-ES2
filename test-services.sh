#!/bin/bash

# Quick reference for testing the microservices

echo "╔════════════════════════════════════════════════════════════════╗"
echo "║          MICROSERVICES QUICK REFERENCE                        ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""

# Define colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}CURRENCY REPORT (Port 8102)${NC}"
echo "Health:"
curl -s http://localhost:8102/health | jq .
echo ""
echo "Quote USD→BRL:"
curl -s "http://localhost:8102/quote?from=USD&to=BRL" | jq .
echo ""

echo -e "${BLUE}CURRENCY HISTORY (Port 8103)${NC}"
echo "Health:"
curl -s http://localhost:8103/health | jq .
echo ""
echo "History USD→BRL:"
curl -s "http://localhost:8103/history?from=USD&to=BRL" | jq .
echo ""

echo -e "${BLUE}ALL SERVICES${NC}"
docker ps --format "table {{.Names}}\t{{.Status}}"
