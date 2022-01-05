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
  lat: any;
  lng: any;
  WeatherData: any;
  appid: String;

  ngOnInit(): void {
    this.appid = Liferay.Language.get("openweathermap-api-key");
    this.WeatherData = {
      main: {},
      isDay: false,
    };
    this.getLocation();
  }
  onSave(event: any) {
    console.log("WeatherComponent.onsave");
  }
  getWeather() {
    console.log("getWeather", this.lat, this.lng);
    let url =
      "https://api.openweathermap.org/data/2.5/weather?q=Pasig" +
      "&appid=" +
      this.appid;
    if (this.lat && this.lng) {
      url =
        "https://api.openweathermap.org/data/2.5/weather?lat=" +
        this.lat +
        "&lon=" +
        this.lng +
        "&appid=" +
        this.appid;
    }
    console.log(url);
    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        this.setWeatherData(data);
      });
  }
  setWeatherData(data: any) {
    this.WeatherData = data;
    let sunsetTime = new Date(this.WeatherData.sys.sunset * 1000);
    let sunriseTime = new Date(this.WeatherData.sys.sunrise * 1000);
    this.WeatherData.sunset_time = sunsetTime.toLocaleTimeString();
    let currentDate = new Date();
    this.WeatherData.isDay =
      currentDate.getTime() > sunriseTime.getTime() &&
      currentDate.getTime() < sunsetTime.getTime();
    this.WeatherData.temp_celcius = (
      this.WeatherData.main.temp - 273.15
    ).toFixed(0);
    this.WeatherData.temp_min = (
      this.WeatherData.main.temp_min - 273.15
    ).toFixed(0);
    this.WeatherData.temp_max = (
      this.WeatherData.main.temp_max - 273.15
    ).toFixed(0);
    this.WeatherData.temp_feels_like = (
      this.WeatherData.main.feels_like - 273.15
    ).toFixed(0);
    console.log(this.WeatherData);
  }
  getLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position: any) => {
          if (position) {
            console.log(
              "Latitude: " +
                position.coords.latitude +
                "Longitude: " +
                position.coords.longitude
            );
            this.lat = position.coords.latitude;
            this.lng = position.coords.longitude;
            console.log(this.lat);
            console.log(this.lng);
            this.getWeather();
          }
        },
        (error: any) => {
          console.log(error);
          this.getWeather();
        }
      );
    } else {
      alert("Geolocation is not supported by this browser.");
    }
  }
}
