import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GipherManagerService {
  gipherManagerEndpoint: string;
  giphyEndPoint: string;
  constructor(private http: HttpClient) {
    this.gipherManagerEndpoint = "http://localhost:9002/api/v1/gifservice";
    this.giphyEndPoint = "https://api.giphy.com/v1/gifs/";
  }
  getBookmarks() {
    const url = `${this.gipherManagerEndpoint}/gif/bookmarks`;
    return this.http.get(url);
  }
  getFavourites() {
    const url = `${this.gipherManagerEndpoint}/gif/favourites`;
    return this.http.get(url);
  }
  bookmark(gif) {
    const url = `${this.gipherManagerEndpoint}/gif/bookmark`;
    return this.http.post(url, gif);
  }
  removeBookmark(gif) {
    const url = `${this.gipherManagerEndpoint}/gif/removebookmark`;
    return this.http.post(url, gif);
  }
  favourite(gif) {
    const url = `${this.gipherManagerEndpoint}/gif/favourite`;
    return this.http.post(url, gif);
  }
  removeFavourite(gif) {
    const url = `${this.gipherManagerEndpoint}/gif/removefavourite`;
    return this.http.post(url, gif);
  }
  getSearchedGifs(keyword: string) {
    const url = `${this.giphyEndPoint}search?api_key=imLleBbW53pJzIKko6ebznqgopQda4of&q=/${keyword}`;
    return this.http.get(url);
  }
  saveSearchKeyWord(keyword: string) {
    const url = `${this.gipherManagerEndpoint}/gif/search/${keyword}`;
    return this.http.get(url);
  }
  getTrendingGifs() {
    const url = `${this.giphyEndPoint}trending?api_key=imLleBbW53pJzIKko6ebznqgopQda4of`;
    return this.http.get(url);
  }

}
