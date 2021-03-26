import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    let todoModel = TodoModel.Companion()

    private var sum: String {
        todoModel.addTodo(title: "Afrojack")
        return "\(todoModel.getAllTodo()[0].title)"
    }
    var body: some View {
        Text(greet())
        Text(sum)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
