import { Component } from "@angular/core";

import LiferayParams from "../types/LiferayParams";

declare const Liferay: any;

@Component({
  selector: "app-root",
  templateUrl:
    Liferay.ThemeDisplay.getPathContext() +
    "/o/angular-routing-demo-portlet/app/app.component.html",
})
export class AppComponent {
  params: LiferayParams;
  labels: any;
  title = "angular-routing-demo-portlet";

  constructor() {
    this.labels = {
      portletNamespace: Liferay.Language.get("portlet-namespace"),
      contextPath: Liferay.Language.get("context-path"),
      portletElementId: Liferay.Language.get("portlet-element-id"),
    };
  }

  get configurationJSON() {
    return JSON.stringify(this.params.configuration, null, 2);
  }
}
