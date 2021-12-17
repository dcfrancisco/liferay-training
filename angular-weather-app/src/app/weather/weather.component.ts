import { Component, OnInit } from "@angular/core";

import LiferayParams from "../../types/LiferayParams";

declare const Liferay: any;

@Component({
  selector: "weather",
  templateUrl:
    Liferay.ThemeDisplay.getPathContext() +
    "/o/angular-weather-app/app/weather.component.html",
})
export class WeatherComponent implements OnInit {
  ngOnInit(): void {
    console.log("WeatherComponent.ngOnInit");
  }
}
