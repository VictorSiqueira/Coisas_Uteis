AP = AirPassengers
summary(AP)

plot(AP, ylab="passageiros", xlab="alou")

plot(decompose(AP))

install.packages("forecast")

library(forecast)

amostra =  auto.arima(AP)

plot(forecast(amostra, h=24))