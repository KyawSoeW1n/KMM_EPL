import SwiftUI
import shared

struct HomeScreen: View {
    @StateObject var viewModel = HomeViewModel()
    
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
    
    var body: some View {
        NavigationStack{
            
            ScrollView{
                LazyVGrid(columns: gridColumns, spacing: 16){
                    
                    ForEach(viewModel.teams, id: \.idTeam){team in
                        
                        NavigationLink(value: team){
                            TeamGridItem(teamData: team)
                                .task {
                                    if team == viewModel.teams.last && !viewModel.isLoading && !viewModel.isLoadFinished {
                                        await viewModel.loadTeamList()
                                    }
                                }
                            
                        }
                        .buttonStyle(PlainButtonStyle())
                    }
                    
                    if viewModel.isLoading {
                        Section(footer: ProgressView()){}
                    }
                    
                }
                .padding(.horizontal, 12)
                //                .navigationDestination(for: Movie.self){movie in
                //                    DetailScreen(movie: movie)
                //                }
                
            }
            .navigationTitle("EPL")
            
        }
        .task {
            await viewModel.loadTeamList()
        }
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
