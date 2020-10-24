import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GipherManagerService } from '../../gipher-manager.service';

@Component({
  selector: 'app-bookmarks',
  templateUrl: './bookmarks.component.html',
  styleUrls: ['./bookmarks.component.css']
})
export class BookmarksComponent implements OnInit {
  bookmarkedGifs: any;
  constructor(private service: GipherManagerService, private router: Router, ) { }

  ngOnInit() {
    this.service.getBookmarks().subscribe(data => {
      this.bookmarkedGifs = data;
    });
  }

  removeBookmark(gif) {
    this.service.removeBookmark(gif).subscribe(data => {
     
    });
    let modifiedGIFs = [];
    for (let g of this.bookmarkedGifs) {
      if (g.gifId != gif.gifId) {
        modifiedGIFs.push(g);
      }
    }
    this.bookmarkedGifs = modifiedGIFs;
  }
}