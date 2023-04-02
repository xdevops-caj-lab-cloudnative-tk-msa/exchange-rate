# Exchange Rate

## Local run

```bash
mvn clean install
mvn spring-boot:run
```

## Test

Request:
```bash
http :8080/exchangerates/latest?base=RUB
```

Response:
```json
{
  "base": "RUB",
  "rates": {
    "EUR": 0.011866105,
    "USD": 0.012899035
  }
}
```