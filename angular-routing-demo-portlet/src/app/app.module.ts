import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppComponent } from "./app.component";
import { APP_BASE_HREF } from "@angular/common";
import { AppRoutingModule, routingComponents } from "./app-routing.module";

@NgModule({
  imports: [BrowserModule, AppRoutingModule],
  declarations: [AppComponent, routingComponents],
  entryComponents: [AppComponent],
  bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
  providers: [],
})
export class AppModule {
  // Avoid bootstraping any component statically because we need to attach to
  // the portlet's DOM, which is different for each portlet instance and,
  // thus, cannot be determined until the page is rendered (during runtime).
  ngDoBootstrap() {}
}
