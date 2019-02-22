import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GipherManagerService } from '../../gipher-manager.service';


@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {

  gifs: any;

  constructor(private router: Router, private service: GipherManagerService) { }

  ngOnInit() {
    this.getFavourites();
  }

  onNavigate(link) {
    window.open(link, "blank");
  }
  removeFavourite(gif) {
    this.service.removeFavourite(gif).subscribe(data => {

    });
    let modifiedGIFs = [];
    for (let g of this.gifs) {
      if (g.gifId != gif.gifId) {
        modifiedGIFs.push(g);
      }
    }
    this.gifs = modifiedGIFs;
  }
  getFavourites() {
    this.service.getFavourites().subscribe(data => {
      this.gifs = data;

    });
  }

}