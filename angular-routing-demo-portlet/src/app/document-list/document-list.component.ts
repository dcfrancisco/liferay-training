import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-document-list',
  template: `
    <p>
      We are in the DOCUMENTS view but still on the same page in Liferay!!
    </p>
  `,
  styles: []
})
export class DocumentListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
