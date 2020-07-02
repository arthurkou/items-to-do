import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number;
  todo: Todo

  constructor(
    private todoService: TodoDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from url params

    this.todo = new Todo(this.id, '', false, new Date()); //default todo

    if (this.id != -1) {
      this.todoService.retriveTodo('in28minutes', this.id).subscribe(
        data => {
          this.todo = data
        }
      );
    }
  }

  saveTodo() {
    //create new todo
    if (this.id === -1) {
      this.todoService.createTodo('in28minutes', this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['todos']);
        }
      )
    } else {
      //update todo
      this.todoService.updateTodo('in28minutes', this.id, this.todo).subscribe(
        data => {
          console.log(data);
          console.log(this.todo)
          this.router.navigate(['todos']);
        }
      )
    }
  }
}
