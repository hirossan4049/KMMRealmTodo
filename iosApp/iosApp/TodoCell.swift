//
//  TodoCell.swift
//  iosApp
//
//  Created by craptone on 2021/03/27.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct TodoCell: View {
    var title = ""
    
//    init(title: String) {
//        self.title = title
//    }
    
    var body: some View {
        HStack {
            Image(systemName: "circle")
                .padding(.leading, 8.0)
            Text(title)
                .padding(.horizontal, 8.0)
        }
    }
}

struct TodoCell_Previews: PreviewProvider {
    static var previews: some View {
        TodoCell(title: "testffffff")
    }
}
