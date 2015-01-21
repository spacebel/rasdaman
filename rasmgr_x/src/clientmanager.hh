/*
 * This file is part of rasdaman community.
 *
 * Rasdaman community is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Rasdaman community is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with rasdaman community.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */


#ifndef RASMGR_X_SRC_CLIENTMANAGER_HH_
#define RASMGR_X_SRC_CLIENTMANAGER_HH_

#include <boost/cstdint.hpp>
#include <boost/scoped_ptr.hpp>
#include <boost/shared_ptr.hpp>
#include <boost/thread/shared_mutex.hpp>
#include <boost/thread/thread.hpp>
#include <map>
#include <string>

#include "../../common/src/time/timer.hh"
#include "../../common/src/zeromq/zmq.hh"

#include "usermanager.hh"
#include "client.hh"
#include "clientcredentials.hh"
#include "servermanager.hh"

namespace rasmgr
{

class ClientManager
{
public:
    /**
     * Initialize a new instance of the ClientManager class.
     */
    ClientManager(boost::shared_ptr<UserManager> userManager);

    /**
     * Destruct the ClientManager class object.
     */
    virtual ~ClientManager();

    /**
     * Authenticate and connect the client to RasMgr.
     * If the authentication is successful, the UUID assigned to the client will be returned.
     * If the authentication fails, an exception is thrown.
     * @param clientCredentials Credentials used to authenticate the client.
     * @param clientUUID Out parameter for clientUUID
     * @param clientId Out parameter for int client id.
     * @return the UUID assigned to the client.
     * @throws std::runtime_error
     */
    void connectClient(const ClientCredentials& clientCredentials, std::string& out_clientUUID);

    /**
     * Disconnect the client from RasMgr and remove its information from RasMgr database.
     * @param clientId UUID of the client that will be removed.
     */
    void disconnectClient(const std::string& clientId);

    /**
     * @brief openClientDbSession Open a database session for the client with the given id and provide a unique session id.
     * @param clientId Unique ID identifying the client
     * @param dbName  Database that the client wants to open
     * @param assignedServer  RasServer that will be assigned to the client if this operation succeeds.
     * @param out_sessionId  Session ID that will uniquely identify this session together with the clientID.
     */
    void openClientDbSession(std::string clientId, const std::string& dbName,boost::shared_ptr<RasServer> assignedServer, std::string& out_sessionId);

    void closeClientDbSession(const std::string& clientId, const std::string& sessionId);

    /**
     * Extend the liveliness of the client and prevent it
     * from being removed from RasMgr database from the list of active clients.
     * @param clientId UUID of the client
     */
    void keepClientAlive(const std::string& clientId);

private:
    zmq::context_t context;
    boost::scoped_ptr<zmq::socket_t> controlSocket;
    std::string controlEndpoint;

    boost::scoped_ptr<boost::thread> managementThread; /*! Thread used to manage the list of clients and remove dead ones */

    std::map<std::string, boost::shared_ptr<Client> > clients; /*! list of active clients */
    boost::shared_mutex clientsMutex; /*! Mutex used to synchronize access to the clients object*/
    boost::shared_ptr<UserManager> userManager;

    /**
     * Evaluate the list of clients and remove the ones that have died.
     */
    void evaluateClientsStatus();

};

} /* namespace rasmgr */

#endif /* CLIENTMANAGER_HH_ */