import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ArticleListComponent} from "./article-list/article-list.component";
import {DocumentListComponent} from "./document-list/document-list.component";
import {PageNotFoundComponent} from "./page-not-found.component";

const routes: Routes = [
  {path: '', redirectTo: '/articles', pathMatch: 'full'},
  {path: 'articles', component: ArticleListComponent},
  {path: 'documents', component: DocumentListComponent},
  {path: '**',   component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(
    routes,
    {useHash: true, enableTracing: false}
  )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ArticleListComponent, DocumentListComponent, PageNotFoundComponent]
