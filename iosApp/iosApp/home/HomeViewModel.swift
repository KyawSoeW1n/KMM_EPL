//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Kurio Tetsuya on 5/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

extension HomeScreen{
    @MainActor class HomeViewModel : ObservableObject{
        private let getTeamUseCase = GetTeamListUseCase.init()
        
        @Published private(set) var teams:[TeamData] = []
        @Published private(set) var isLoading : Bool = false
        
        private(set)var isLoadFinished  : Bool = false
        
        
        func loadTeamList() async {
            
            if isLoading {
                return
            }
            
            do {
                
                let teamList = try await getTeamUseCase.invoke(name : "English Premier League")
                isLoading = false
                isLoadFinished = teams.isEmpty
                
                
                self.teams = teamList
                
            } catch {
                isLoading = false
                isLoadFinished = true
                
                print(error.localizedDescription)
            }
            
        }
    }
}
