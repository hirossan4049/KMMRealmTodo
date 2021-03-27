import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct TodoStruct: Identifiable {
    var id: ObjectIdentifier
    var title: String
    
    init(todo: Todo, id: ObjectIdentifier){
        self.id = id
        self.title = todo.title
    }
}

class TodoEventFetcher: ObservableObject {
    @Published var todos: [TodoStruct] = []
    let todoModel = TodoModel.Companion()

    
    init() {
        fetchTodo()
    }
    
    func fetchTodo() {
        for (index,item) in todoModel.getAllTodo().reversed().enumerated(){
            self.todos.append(TodoStruct(todo: item, id: index))
        }
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

    private var sum: String {
        todoModel.addTodo(title: "Afrojack")
        return "\(todoModel.getAllTodo()[0].title)"
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
        
        List(todoFetcher.$todos) { item in
            Text(item.title)
        }
    }
    
    // FIXME
    func updateTodo() {
//        self.todos = []

    }

    func addTodo() {
        todoModel.addTodo(title: title)
        self.title = ""
//        updateTodo()
        print("追加しました, \(title)")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
