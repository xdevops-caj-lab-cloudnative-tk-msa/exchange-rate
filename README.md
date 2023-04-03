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

## 构建容器镜像

先构建应用：
```bash
mvn clean install
```

构建容器镜像：

```bash
podman build -t exchange-rate .
```

推送容器镜像到镜像仓库：

```bash
podman login quay.io
# replace as your repository
podman tag exchange-rate:latest quay.io/xxx/exchange-rate:latest
podman push quay.io/xxx/exchange-rate:latest
```
