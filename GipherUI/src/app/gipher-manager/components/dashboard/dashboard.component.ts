import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GipherManagerService } from '../../gipher-manager.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  gifs: any;
  bookmarks;
  favourites;
  searchForm = new FormGroup({
    keyword: new FormControl('', Validators.required)
  });
  constructor(private service: GipherManagerService, private router: Router) { }

  ngOnInit() {
    this.getTrendingGifs();
  }

  onNavigate(link) {
    window.open(link, "blank");
  }

  search() {
    this.service.getSearchedGifs(this.searchForm.get('keyword').value).subscribe(data => {
      this.gifs = this.formatObjects(data['data']);
    });
    this.service.saveSearchKeyWord(this.searchForm.get('keyword').value).subscribe();
  }
  getTrendingGifs() {
    this.service.getTrendingGifs().subscribe(data => {
      this.gifs = this.formatObjects(data['data']);
    });
  }
  formatObjects(objects) {
    let gifs = [];
    for (let object of objects) {
      let modifiedObject = {
        gifId: object.id,
        title: object.title,
        original: object.images.original.url,
        preview: object.images.preview_gif.url,
        bookmark: false,
        favourite: false
      };
      gifs.push(modifiedObject);
    }
    return gifs;
  }

  bookmark(gif) {
    this.service.bookmark(gif).subscribe();
    for (let g of this.gifs) {
      if (g.gifId == gif.gifId) {
        g.bookmark = true;
      }
    }
  }

  favourite(gif) {
    this.service.favourite(gif).subscribe();
    for (let g of this.gifs) {
      if (g.gifId == gif.gifId) {
        g.favourite = true;
      }
    }
  }

  removeBookmark(gif) {
    this.service.removeBookmark(gif).subscribe();
    for (let g of this.gifs) {
      if (g.gifId == gif.gifId) {
        g.bookmark = false;
      }
    }
  }

  removeFavourite(gif) {
    this.service.removeFavourite(gif).subscribe();
    for (let g of this.gifs) {
      if (g.gifId == gif.gifId) {
        g.favourite = false;
      }
    }
  }
  checkAlreadyBookmarkAndFavourite() {
    if (this.gifs.length > 0) {
      if (this.bookmarks.length > 0) {
        for (let userBookmarkImage of this.bookmarks) {
          for (let gif of this.gifs) {
            if (userBookmarkImage.gifId == gif.gifId) {
              gif.bookmark = true;
            }
          }
        }
      }
      if (this.favourites.length > 0) {
        for (let userFavouriteImage of this.favourites) {
          for (let gif of this.gifs) {
            if (userFavouriteImage.gifId == gif.gifId) {
              gif.favourite = true;
            }
          }
        }
      }
    }
  }
}
