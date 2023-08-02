package com.atomic.shellapp.data.model

data class Sport(val name: String, val description: String) {
    companion object {
        fun createMockedSports(): List<Sport> = listOf(
            Sport("Cycling", "CyclingCyclingCyclingCyclingCycling"),
            Sport(
                "Association football",
                "Association football Association football Association football Association football"
            ),
            Sport("Hockey", "HockeyHockeyHockeyHockeyHockey"),
            Sport("Basketball", "BasketballBasketballBasketballBasketballBasketball"),
            Sport("Ruby", "RubyRubyRubyRubyRuby"),
            Sport("Cricket", "CricketCricketCricketCricketCricket"),
            Sport("Boxing", "BoxingBoxingBoxingBoxingBoxing"),
            Sport("Rowing", "RowingRowingRowingRowingRowing"),
            Sport("Volleyball", "VolleyballVolleyballVolleyballVolleyballVolleyball")
        )
    }
}
