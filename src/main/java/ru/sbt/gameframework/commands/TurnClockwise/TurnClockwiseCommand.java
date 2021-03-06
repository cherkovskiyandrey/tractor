/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.gameframework.commands.TurnClockwise;

import ru.sbt.gameframework.commands.Command;
import ru.sbt.gameframework.units.Unit;
import ru.sbt.gameframework.units.exceptions.CantExecuteCommand;
import ru.sbt.gameframework.units.exceptions.UnsupportedCommand;

/**
 *
 * @author admin
 */
public class TurnClockwiseCommand implements Command {
        
    public void execute(Unit unit) throws CantExecuteCommand {
        if(unit instanceof TurnClockwiseHandler) {
            ((TurnClockwiseHandler)unit).turnClockwise();
            return;
        }
        throw new UnsupportedCommand();
    }
    
}
