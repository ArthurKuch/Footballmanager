CREATE TABLE team (
                      team_id INT PRIMARY KEY AUTO_INCREMENT,
                      team_name VARCHAR(255),
                      balance DOUBLE,
                      transfer_commission_percent INT
);

CREATE TABLE player (
                        player_id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255),
                        surname VARCHAR(255),
                        age INT,
                        experience INT,
                        team_id INT,
                        FOREIGN KEY (team_id) REFERENCES team(team_id)
);
