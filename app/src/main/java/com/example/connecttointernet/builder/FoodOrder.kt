package com.example.connecttointernet.builder

class FoodOrder private constructor(builder: Builder){
    private val bread: String?
    private val condiments: String?
    private val meat: String?
    private val fish: String?

    init {
        let {
            bread = builder.bread
            condiments = builder.condiments
            meat = builder.meat
            fish = builder.fish
        }
    }

    class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null
    ){
        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(this)
    }
}