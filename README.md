# Bike Company
[![release](https://img.shields.io/github/release/jfveronelli/bikecompany.svg#1)](https://github.com/jfveronelli/bikecompany/releases/latest)
[![status](https://travis-ci.org/jfveronelli/bikecompany.svg?branch=master)](https://travis-ci.org/jfveronelli/bikecompany)
[![coverage](https://codecov.io/gh/jfveronelli/bikecompany/branch/master/graph/badge.svg)](https://codecov.io/gh/jfveronelli/bikecompany)

## Design

The domain was modeled using rich model objects, instead of thin objects and services.


## Development practices

Some good practices applied here are:

- KISS: only what was requested was modeled, some improvements could be:
  - rental operations modeling (order, cancel, modify).
  - record time frames (from, to) and create the most suitable rental type for the client.
- External input validation.
- Descriptive names in classes, methods, variables.
- Usage of BigDecimal for currency amounts.
- Unit tests.
- Continuous integration using Travis CI.


## How to run tests

```bash
mvn clean test
```

