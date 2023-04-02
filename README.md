# Exchange Rate

## Local run

```bash
mvn clean install
mvn spring-boot:run
```

## Test

Request:
```bash
http :8080/exchangerates/latest?base=USD
```

Response:
```json
{
    "base": "USD",
    "rates": {
        "EUR": 0.011866105,
        "RUB": 84.273655,
        "USD": 0.012899035
    }
}
```