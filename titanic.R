install.packages("titanic")

library(titanic)

amostra = titanic_train

amostra$Survived = as.factor(amostra$Survived)
amostra$Sex = as.factor(amostra$Sex)
amostra$Pclass = as.factor(amostra$Pclass)


library(ggplot2)
ggplot(data=amostra,aes(x=Sex, fill=Survived))+geom_bar()


amostra$child = 0
amostra$child[amostra$Age<18] = 1 
amostra$child = as.factor(amostra$child)

ggplot(data=amostra,aes(x=child, fill=Survived))+geom_bar()


ggplot(data=amostra,aes(x=Sex, fill=Survived))+geom_bar(position='fill')+facet_wrap(~Pclass)
