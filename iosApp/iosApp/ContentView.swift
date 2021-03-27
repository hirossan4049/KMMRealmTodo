import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct TodoStruct: Identifiable {
    var id: Int
    var title: String
    
    init(todo: Todo, id: Int){
        self.id = id
        self.title = todo.title
    }
}

class TodoEventFetcher: ObservableObject {
    @Published var todos: [TodoStruct] = []
    var todoModels: [Todo] = []
    let todoModel = TodoModel.Companion()

    
    init() {
        fetchTodo()
    }
    
    func fetchTodo() {
        todoModels = todoModel.getAllTodo().reversed()
        for (index,item) in todoModels.enumerated(){
            self.todos.append(TodoStruct(todo: item, id: index))
        }
    }
    func updateTodo(){
        todos = []
        fetchTodo()
    }
}

struct ContentView: View {
    let todoModel = TodoModel.Companion()

//    @State var todos:[TodoStruct] = []
    @ObservedObject var todoFetcher = TodoEventFetcher()

    @State private var title = ""
    
    init() {
//        self.todos = todoModel.getAllTodo()
//        self.updateTodo()
    }


    var body: some View {
        HStack(spacing: 16.0){
            TextField("Add", text: $title)
                .padding(.leading, 12.0)
            Button("Push me") {
                addTodo()
            }.padding(.trailing, 12.0)
        }
        .padding(.top, 16.0)
        
        List(todoFetcher.todos) { item in
            TodoCell(title: item.title)
                .onTapGesture {
                    deleteTodo(index: item.id)
                }
        }
    }
    
    func deleteTodo(index: Int) {
        todoModel.deleteTodo(todo: todoFetcher.todoModels[index])
        todoFetcher.updateTodo()
    }

    func addTodo() {
        todoModel.addTodo(title: title)
        self.title = ""
        todoFetcher.updateTodo()
        print("追加しました, \(title)")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
