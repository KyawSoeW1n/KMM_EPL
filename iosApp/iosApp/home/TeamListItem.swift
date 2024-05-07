//
//  TeamListItem.swift
//  iosApp
//
//  Created by Kurio Tetsuya on 5/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TeamGridItem: View {
    let teamData: TeamData
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            ZStack{
                
                AsyncImage(url: URL(string: teamData.url)){image in
                    image.resizable()
                }placeholder: {
                    Color.gray
                }
                
            }
            .frame(maxWidth: .infinity, idealHeight: .infinity)
            .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(teamData.name)
                .font(.title3)
                .fontWeight(.bold)
                .lineLimit(2)
            
        }
        .frame(maxWidth: .infinity, maxHeight: 260)
    }
}

struct TeamGridItem_Previews: PreviewProvider {
    static var previews: some View {
        TeamGridItem(teamData: sampleTeam)
    }
}
