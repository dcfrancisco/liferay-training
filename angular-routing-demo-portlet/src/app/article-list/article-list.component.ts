import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-article-list',
  template: `
    <p>
      We are in the ARTICLES view but still on the same page in Liferay!!
    </p>
  `,
  styles: []
})
export class ArticleListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
